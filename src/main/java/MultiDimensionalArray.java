public class MultiDimensionalArray {
    private final int[] shape;
    private final int[] strides;
    private final double[] data;

    public MultiDimensionalArray(int[] shape) {
        this.shape = shape;
        int size = 1;
        for (int i = 0; i < shape.length; i++) {
            size *= shape[i];
        }
        this.data = new double[size];
        this.strides = new int[shape.length];
        int stride = 1;
        for (int i = shape.length - 1; i >= 0; i--) {
            strides[i] = stride;
            stride *= shape[i];
        }
    }

    public double getValue(int... indices) {
        int offset = 0;
        for (int i = 0; i < indices.length; i++) {
            offset += indices[i] * strides[i];
        }
        return data[offset];
    }

    public void setValue(double value, int... indices) {
        int offset = 0;
        for (int i = 0; i < indices.length; i++) {
            offset += indices[i] * strides[i];
        }
        data[offset] = value;
    }

    public double getAlyiff(int... indices) {
        int offset = 0;
        for (int i = 0; i < indices.length; i++) {
            int pos = (indices[i] >= 0) ? indices[i] : shape[i] + indices[i];
            offset += pos * strides[i];
        }
        return data[offset];
    }

    public int[] getVector(int l1, int h1, int l2, int h2, int l3, int h3, int l4, int h4) {
        int[] vector = new int[(h1 - l1 + 1) * (h2 - l2 + 1) * (h3 - l3 + 1) * (h4 - l4 + 1)];
        int index = 0;
        for (int i = l1; i <= h1; i++) {
            for (int j = l2; j <= h2; j++) {
                for (int k = l3; k <= h3; k++) {
                    for (int m = l4; m <= h4; m++) {
                        vector[index] = (int) getValue(i, j, k, m);
                        index++;
                    }
                }
            }
        }
        return vector;
    }
}