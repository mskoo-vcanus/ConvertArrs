import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        float[] floatD = { 15.22f, 15.23f};
        byte[] byteD = floatarr2bytearr1(floatD);
        float[] fArr = arr2floatarr(byteD);

        for (int i = 0; i < fArr.length; i++)
        {
            System.out.println(fArr[i]);
        }

    }

    //f->b no1
    public static byte[] floatarr2bytearr1(float[] fArr) throws IOException {
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        DataOutputStream ds = new DataOutputStream(bas);
        for (float f : fArr)
            ds.writeFloat(f);
        byte[] bytes = bas.toByteArray();
        return bytes;
    }

    //f->b no2
    public static byte[] floatarr2bytearr2(float[] d){
        byte[] r = new byte[d.length * 4];
        for (int i = 0; i < d.length; i++) {
            byte[] s = floatToBytes(d[i]);
            for (int j = 0; j < 4; j++)
                r[4 * i + j] = s[j];
        }
        return r;
    }

    public static byte[] floatToBytes(float d) {
        int i = Float.floatToRawIntBits(d);
        return intToBytes(i);
    }

    public static byte[] intToBytes(int v) {
        byte[] r = new byte[4];
        for (int i = 0; i < 4; i++) {
            r[i] = (byte) ((v >>> (i * 8)) & 0xFF);
        }
        return r;
    }

    //b->f
    public static float[] arr2floatarr(byte[] buffer) throws IOException {
        ByteArrayInputStream bas = new ByteArrayInputStream(buffer);
        DataInputStream ds = new DataInputStream(bas);
        float[] fArr = new float[buffer.length / 4];  // 4 bytes per float
        for (int i = 0; i < fArr.length; i++)
        {
            fArr[i] = ds.readFloat();
        }
        return fArr;
    }



}
