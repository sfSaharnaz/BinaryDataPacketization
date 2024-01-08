package org.example.binary.data.packer;

public class DataPacket {
    byte[] buffer;
    int size;


    public DataPacket(byte[] buffer, int size) {
        this.buffer = buffer;
        this.size = size;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
