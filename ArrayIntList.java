/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h211;

/**
 *
 * @author 84399
 */
public class ArrayIntList {

    private int[] elementData;
    private int size;

    public ArrayIntList() {
        this.size = 0;
    }

    public void setElementData(int[] elementData) {
        this.elementData = elementData;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getElementData() {
        return elementData;
    }

    public int getSize() {
        return size;
    }

    public ArrayIntList(int[] elementData, int size) {
        this.elementData = elementData;
        this.size = size;
    }

    public ArrayIntList fromCounts() {
        ArrayIntList list2 = new ArrayIntList();
        for (int i = 0; i < this.size; i += 2) {
            list2.setSize(list2.getSize() + this.elementData[i]);
        }
        // 5, 2, 2, -5, 4, 3, 2, 4, 1, 1, 1, 0, 2, 17 
        //2, 2, 2, 2, 2, -5, -5, 3, 3, 3, 3, 4, 4, 1, 0, 17, 17
        int[] a = new int[list2.getSize()];
        int k = 0;
        for (int i = 1; i < this.size; i += 2) {
            for (int j = 0; j < this.elementData[i - 1]; j++) {
                a[k++] = this.elementData[i];
            }
        }
        list2.setElementData(a);
        return list2;
    }
}
