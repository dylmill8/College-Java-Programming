public class BlockChainSecure {
    public FancyBlockChain fbc;
    public Block[] btable;
    public Hasher hash = new Hasher();

    public void print() {
        fbc.print();
        System.out.print("Hash Table: ");
        for (int i = 0; i < btable.length; i++) {
            try {
                if(btable[i].removed) {
                    System.out.print("removed(" + btable[i].timestamp + ") ");
                } else {
                    System.out.print(btable[i].timestamp + " ");
                }
            } catch (NullPointerException e) {
                System.out.print("null ");
            }
        }
        System.out.println();
        System.out.println();
    }
    public boolean isPrime(int prime) {
        if (prime <= 1) { // 1 is smallest non-prime (base case)
            return false;
        } else if (prime <= 3) { // 2 and 3 are smallest primes (base case)
            return true;
        }

        if (prime % 2 == 0 || prime % 3 == 0) { //if the number is divisible it is not prime
            return false;
        }

        // start from 5 (next lowest prime), if prime is not a prime number it has a factor between 1 and sqrt(prime) + 1.
        // we checked multiples of 2, 3 and by extension 4, 6, 8, and 9 we only need to check multiples of 5 or 7.
        for (int i = 5; i <= ((int) Math.sqrt(prime)) + 1; i = i + 6) {
            if (prime % i == 0 || prime % (i + 2) == 0) { //if divisible it is not prime
                return false;
            }
        }
        return true; //found no factors from 2 to sqrt(prime), so number is prime
    }
    public int doubleHash (Block block, int prime, int k, boolean linear) {
        int hashVal;
        int hash1 = hash.hash1(block.data, prime);
        int hash2 = hash.hash2(block.data, prime);
        if (linear) {
            hashVal = (hash1 + k) % prime;
        } else {
            hashVal = (hash1 + (k * hash2)) % prime;
        }
        return hashVal;
    }
    public BlockChainSecure(int capacity) {
        fbc = new FancyBlockChain(capacity);
        int prime = capacity + 1;
        while (!isPrime(prime)) {
            prime++;
        }
        btable = new Block[prime];
    }
    public BlockChainSecure(Block[] initialBlocks) {
        fbc = new FancyBlockChain(initialBlocks); // create heap

        int prime = initialBlocks.length + 1; // find prime for hash table size
        while (!isPrime(prime)) {
            prime++;
        }
        btable = new Block[prime];

        for (int i = 0; i < initialBlocks.length; i++) { // Hash each block and add to the table
            int k = 0;
            boolean linear = false;
            int loopCheck = doubleHash(initialBlocks[i], prime, k, linear);

            while(true) {
                int hashValue = doubleHash(initialBlocks[i], prime, k, linear);
                if (btable[hashValue] == null) { // break if we find an empty slot in hash table
                    btable[hashValue] = initialBlocks[i];
                    break;
                }
                k++; // increment k if there is a collision
                if (k > 1 && loopCheck == hashValue) { // check for infinite loop
                    linear = true;
                    k = 0;
                }
            }
        }
    }
    public int length() { return fbc.size; }
    public boolean addBlock(Block newBlock) {
        if(!fbc.addBlock(newBlock)) { // if the block was not added in the heap return false
            return false;
        }
        int k = 0;
        boolean linear = false;
        int loopCheck = doubleHash(newBlock, btable.length, k, linear);

        while(true) {
            int hashValue = doubleHash(newBlock, btable.length, k, linear);
            if (btable[hashValue] == null || btable[hashValue].removed) { // break if we find an empty slot in hash table
                btable[hashValue] = newBlock;
                break;
            }
            k++; // increment k if there is a collision
            if (k > 1 && loopCheck == hashValue) { // check for infinite loop
                linear = true;
                k = 0;
            }
        }
        return true;
    }
    public Block getEarliestBlock() {
        return fbc.getEarliestBlock();
    }
    public Block getBlock(String data) {
        int k = 0;
        boolean linear = false;
        Block temp = new Block();
        temp.data = data;
        int loopCheck = doubleHash(temp, btable.length, k, linear);

        while(true) {
            int hashValue = doubleHash(temp, btable.length, k, linear);
            if (btable[hashValue] != null && !btable[hashValue].removed && data.equals(btable[hashValue].data)) {
                return btable[hashValue];
            } else if ((linear && k >= btable.length) || (btable[hashValue] == null)) { // break if the block can't be found
                return null;
            }
            k++; // increment k if there is a collision
            if (k > 1 && loopCheck == hashValue) { // check for infinite loop
                linear = true;
                k = 0;
            }
        }

    }
    public Block removeEarliestBlock() {
        return fbc.removeEarliestBlock();
    }
    public Block removeBlock(String data) {
        Block block = getBlock(data);
        if (block == null) {
            return null;
        }
        block.removed = true;
        fbc.bchain[block.index] = fbc.bchain[fbc.size - 1];
        fbc.bchain[block.index].index = block.index;
        fbc.bchain[fbc.size - 1] = null;
        fbc.size--;
        if (fbc.bchain[block.index] == null) {
            return block;
        }

        int Parent = (block.index - 1) / 2;
        if (fbc.bchain[block.index].timestamp < fbc.bchain[Parent].timestamp) {
            fbc.swimUp(block.index);
        } else {
            fbc.heapify(block.index);
        }
        return block;
    }
    public void updateEarliestBlock(double nonce) {
        fbc.updateEarliestBlock(nonce);
    }
    public void updateBlock(String data, double nonce) {
        Block block = getBlock(data);
        if (block == null) {
            return;
        }
        block.nonce = nonce;
        block.timestamp = fbc.maxTime + 1;
        fbc.maxTime = block.timestamp;
        fbc.heapify(block.index);
    }

    /*
    public static void main(String[] args) {
        BlockChainSecure BCS = new BlockChainSecure(21);
        BCS.addBlock(new Block("rS2PU84J8E", 45.290835, 478));
        BCS.print();
        BCS.addBlock(new Block("MyXLzQ", 85.044792, 158));
        BCS.print();
        BCS.updateBlock("MyXLzQ", 22.786342);
        System.out.println("Updated Value: " + BCS.getBlock("MyXLzQ").nonce);
        BCS.print();
        BCS.addBlock(new Block("hvs1T", 105.959138, 467));
        BCS.print();
        System.out.println("Earliest Block: " + BCS.getEarliestBlock().timestamp);
        System.out.println("Earliest Block: " + BCS.getEarliestBlock().timestamp);
        System.out.println("Block: " + BCS.getBlock("eotBx"));
        System.out.println();
        BCS.addBlock(new Block("Yu", -51.662591, 477));
        BCS.print();
        System.out.println("Earliest Block: " + BCS.getEarliestBlock().timestamp);
        System.out.println();
        BCS.updateEarliestBlock(-172.503869);
        System.out.println("Updated Value: " + BCS.getBlock("hvs1T").nonce);
        BCS.print();
        BCS.removeEarliestBlock();
        BCS.print();
    }
     */
}
