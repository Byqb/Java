public class PI_Manager_202011111 {
    private String[] productList;
    private int length;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public PI_Manager_202011111() {
        capacity = DEFAULT_CAPACITY;
        productList = new String[capacity];
        length = 0;
    }

    public PI_Manager_202011111(int cap) {
        if (cap <= 0) {
            capacity = DEFAULT_CAPACITY;
        } else {
            capacity = cap;
        }
        productList = new String[capacity];
        length = 0;
    }

    private void reallocate() {
        capacity *= 2;
        String[] newList = new String[capacity];
        for (int i = 0; i < length; i++) {
            newList[i] = productList[i];
        }
        productList = newList;
    }

    public int getLength() {
        return length;
    }

    public void addProduct(String p) {
        if (length == capacity) {
            reallocate();
        }
        productList[length] = p;
        length++;
    }

    public boolean isProductInList(String p) {
        for (int i = 0; i < length; i++) {
            if (productList[i].equals(p)) {
                return true;
            }
        }
        return false;
    }

    public String getProduct(int index) {
        if (index < 0 || index >= length) {
            System.out.println("invalid index: " + index);
            return null;
        }
        return productList[index];
    }

    public String setProduct(int index, String p) {
        if (index < 0 || index >= length) {
            System.out.println("invalid index: " + index);
            return null;
        }
        String oldValue = productList[index];
        productList[index] = p;
        return oldValue;
    }

    public void removeProduct(int index) {
        if (index < 0 || index >= length) {
            System.out.println("invalid index: " + index);
            return;
        }
        for (int i = index; i < length - 1; i++) {
            productList[i] = productList[i + 1];
        }
        productList[length - 1] = null;
        length--;
    }

    public void removeLastProduct() {
        if (length == 0) {
            System.out.println("list is empty");
            return;
        }
        productList[length - 1] = null;
        length--;
    }

    public boolean equals(PI_Manager_202011111 otherList) {
        if (this.length != otherList.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!this.productList[i].equals(otherList.productList[i])) {
                return false;
            }
        }
        return true;
    }

    public void reverse() {
        int left = 0;
        int right = length - 1;
        while (left < right) {
            String temp = productList[left];
            productList[left] = productList[right];
            productList[right] = temp;
            left++;
            right--;
        }
    }

    public boolean isEmpty() {
        if(length==0)
            return true;
        return false;
    }

    public String getLast() {
        if (length == 0) {
            System.out.println("list is empty");
            return null;
        }
        String last = productList[length - 1];
        return last;
    }

    public void setLast(String v) {
        if (length == 0) {
            System.out.println("cannot set last element");
            return;
        }
        productList[length - 1] = v;
    }

    public int countOccurrences(String v) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (productList[i].equals(v)) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        String result ="";
        for (int i = 0; i < length; i++) {
            result += productList[i];
            if (i < length - 1) {
                result += ", ";
            }
        }
        return result;
    }

    public int size() {
        return length;
    }


}
