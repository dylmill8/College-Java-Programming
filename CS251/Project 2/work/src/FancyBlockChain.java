// min heap where the root is the earliest timestamp
public class FancyBlockChain {
    public Block[] bchain;
    int size = 0;
    int maxTime = 0;

    public void print() {
        System.out.print("Block Chain: ");
        for (Block block : bchain) {
            try {
                System.out.print(block.timestamp + " ");
            } catch (NullPointerException e) {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
    public void heapify(int index) {
        int Lchild = 2 * index + 1; //hold positions and values of children & the block we are going to swap
        int Rchild = 2 * index + 2;
        int swap = index;
        int Lval = -1;
        int Rval = -1;

        try { //get Lchild and Rchild values
            Lval = bchain[Lchild].timestamp;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ignored) { }
        try {
            Rval = bchain[Rchild].timestamp;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ignored) { }

        if (Lchild < size && Lval < bchain[swap].timestamp) { // determine which child we are swapping (if any)
            swap = Lchild;
        }
        if (Rchild < size && Rval < bchain[swap].timestamp) {
            swap = Rchild;
        }

        if (swap != index) { // make a swap and recursive call on the index of the swapped child
            Block temp = bchain[index];
            bchain[index] = bchain[swap];
            bchain[swap] = temp;

            bchain[index].index = index; // edit the index values
            bchain[swap].index = swap;

            heapify(swap);
        }
    }
    public void swimUp(int index) {
        int Parent = (index - 1) / 2;
        if (Parent >= 0) {
            if (bchain[index].timestamp < bchain[Parent].timestamp) {
                Block temp = bchain[index];
                bchain[index] = bchain[Parent];
                bchain[Parent] = temp;

                bchain[index].index = index;
                bchain[Parent].index = Parent;

                swimUp(Parent);
            }
        }
    }
    public FancyBlockChain(int capacity) {
        bchain = new Block[capacity];
    }
    public FancyBlockChain(Block[] initialBlocks) {
        bchain = new Block[initialBlocks.length];
        for (int i = 0; i < initialBlocks.length; i++) { //get the size (number of blocks) of the initial array
            bchain[i] = initialBlocks[i];
            bchain[i].index = i;
            size++;
            if (bchain[i].timestamp > maxTime) {
                maxTime = bchain[i].timestamp;
            }
        }
        for (int i = (size / 2) - 1; i >= 0; i--) { // goes through heap bottom-up starting from the last parent
            heapify(i);
        }
    }
    public int length() { return size; }
    public boolean addBlock(Block newBlock) {
        if (size >= bchain.length && newBlock.timestamp < bchain[0].timestamp) { // chain is full and new block is earlier timestamp
            return false;
        } else if (size >= bchain.length) { // chain is full and new block is later timestamp
            if (newBlock.timestamp > maxTime) {
                maxTime = newBlock.timestamp;
            }
            bchain[0].removed = true; // mark the node that is being replaced as removed for the hash table
            newBlock.index = 0;
            bchain[0] = newBlock; // replace the root with new node and swim down (heapify)
            heapify(0);
            return true;
        } else { // insert at bottom and swim up
            if (newBlock.timestamp > maxTime) {
                maxTime = newBlock.timestamp;
            }
            newBlock.index = size;
            bchain[size] = newBlock;
            size++;
            swimUp(size - 1);
            return true;
        }
    }
    public Block getEarliestBlock() {
        try {
            return bchain[0];
        } catch (NullPointerException e) {
            return null;
        }
    }
    public Block getBlock(String data) {
        for (Block block : bchain) {
            try {
                if (block.data.equals(data)) {
                    return block;
                }
            } catch (NullPointerException ignored) { }
        }
        return null;
    }
    public Block removeEarliestBlock() {
        if (size == 0) {
            return null;
        }
        Block ret = bchain[0]; // swap the lowest node to the root and swim down (heapify)
        bchain[0].removed = true;
        bchain[0] = bchain[size - 1];
        bchain[0].index = 0; //update index
        bchain[size - 1] = null; // remove the bottom node which has been swapped to the root (removes duplicate)
        size--;
        if (bchain[0] != null) {
            heapify(0);
        }
        return ret;
    }
    public Block removeBlock(String data) {
        Block ret = null;
        int index = 0;
        for (int i = 0; i < size; i++) { // find the matching block
            try {
                if (bchain[i].data.equals(data)) {
                    index = i; // delete the node and swap the lowest node into its position
                    ret = bchain[i];
                    bchain[i].removed = true;
                    bchain[i] = bchain[size - 1];
                    bchain[i].index = i; // update index
                    bchain[size - 1] = null; // remove bottom node which was swapped up (removes duplicate)
                    size--;
                    if (bchain[index] == null) { // if the block is last in the chain
                        return ret;
                    }
                    break;
                }
            } catch (NullPointerException ignored) { }
        }
        if (ret == null) { // if the node was not found
            return null;
        }

        int Parent = (index - 1) / 2;
        if (bchain[index].timestamp < bchain[Parent].timestamp) { // swim up if the parent is greater than the node
            swimUp(index);
        } else { // swim down if the node is greater than the parent
            heapify(index);
        }
        return ret;
    }
    public void updateEarliestBlock(double nonce) {
        try {
            bchain[0].nonce = nonce;
            bchain[0].timestamp = maxTime + 1;
            maxTime = bchain[0].timestamp;
            heapify(0);
        } catch (NullPointerException ignored) { }
    }
    public void updateBlock(String data, double nonce) {
        for (int i = 0; i < size; i++) { // find the matching block
            try {
                if (bchain[i].data.equals(data)) {
                    bchain[i].nonce = nonce; // update values and swim down (because the new timestamp will be the greatest in the array
                    bchain[i].timestamp = maxTime + 1;
                    maxTime = bchain[i].timestamp;
                    heapify(i);
                    break;
                }
            } catch (NullPointerException ignored) { }
        }
    }

    /*
    public static void main(String[] args) {
        // small test 3
        FancyBlockChain FBC = new FancyBlockChain(21);
        FBC.addBlock(new Block("9KUWYd", 13.404820, 167));
        FBC.print();
        System.out.println("Earliest Block: " + FBC.getEarliestBlock().timestamp);
        FBC.addBlock(new Block("Owy", 120.205486, 434));
        FBC.print();
        System.out.println("Earliest Block: " + FBC.getEarliestBlock().timestamp);
        FBC.addBlock(new Block("UcH", 27.649930, 361));
        FBC.print();
        FBC.updateBlock("9KUWYd", -73.327160);
        FBC.print();
        System.out.println("Updated Value: " + FBC.getBlock("9KUWYd").nonce);
        System.out.println("Get rV7f0iXN2: " + FBC.getBlock("rV7f0iXN2"));
    }
     */
}
