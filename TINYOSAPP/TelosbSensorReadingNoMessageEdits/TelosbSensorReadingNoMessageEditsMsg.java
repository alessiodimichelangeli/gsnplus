/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'TelosbSensorReadingNoMessageEditsMsg'
 * message type.
 */

public class TelosbSensorReadingNoMessageEditsMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 24;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 147;

    /** Create a new TelosbSensorReadingNoMessageEditsMsg of size 24. */
    public TelosbSensorReadingNoMessageEditsMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new TelosbSensorReadingNoMessageEditsMsg of the given data_length. */
    public TelosbSensorReadingNoMessageEditsMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TelosbSensorReadingNoMessageEditsMsg with the given data_length
     * and base offset.
     */
    public TelosbSensorReadingNoMessageEditsMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TelosbSensorReadingNoMessageEditsMsg using the given byte array
     * as backing store.
     */
    public TelosbSensorReadingNoMessageEditsMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TelosbSensorReadingNoMessageEditsMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public TelosbSensorReadingNoMessageEditsMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TelosbSensorReadingNoMessageEditsMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public TelosbSensorReadingNoMessageEditsMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TelosbSensorReadingNoMessageEditsMsg embedded in the given message
     * at the given base offset.
     */
    public TelosbSensorReadingNoMessageEditsMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new TelosbSensorReadingNoMessageEditsMsg embedded in the given message
     * at the given base offset and length.
     */
    public TelosbSensorReadingNoMessageEditsMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <TelosbSensorReadingNoMessageEditsMsg> \n";
      try {
        s += "  [version=0x"+Long.toHexString(get_version())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [interval=0x"+Long.toHexString(get_interval())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [id=0x"+Long.toHexString(get_id())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [count=0x"+Long.toHexString(get_count())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [readingsTemp=";
        for (int i = 0; i < 2; i++) {
          s += "0x"+Long.toHexString(getElement_readingsTemp(i) & 0xffff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [readingsHum=";
        for (int i = 0; i < 2; i++) {
          s += "0x"+Long.toHexString(getElement_readingsHum(i) & 0xffff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [readingsLum=";
        for (int i = 0; i < 2; i++) {
          s += "0x"+Long.toHexString(getElement_readingsLum(i) & 0xffff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [readingsPhoto=";
        for (int i = 0; i < 2; i++) {
          s += "0x"+Long.toHexString(getElement_readingsPhoto(i) & 0xffff)+" ";
        }
        s += "]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: version
    //   Field type: int, unsigned
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'version' is signed (false).
     */
    public static boolean isSigned_version() {
        return false;
    }

    /**
     * Return whether the field 'version' is an array (false).
     */
    public static boolean isArray_version() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'version'
     */
    public static int offset_version() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'version'
     */
    public static int offsetBits_version() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'version'
     */
    public int get_version() {
        return (int)getUIntBEElement(offsetBits_version(), 16);
    }

    /**
     * Set the value of the field 'version'
     */
    public void set_version(int value) {
        setUIntBEElement(offsetBits_version(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'version'
     */
    public static int size_version() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'version'
     */
    public static int sizeBits_version() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: interval
    //   Field type: int, unsigned
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'interval' is signed (false).
     */
    public static boolean isSigned_interval() {
        return false;
    }

    /**
     * Return whether the field 'interval' is an array (false).
     */
    public static boolean isArray_interval() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'interval'
     */
    public static int offset_interval() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'interval'
     */
    public static int offsetBits_interval() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'interval'
     */
    public int get_interval() {
        return (int)getUIntBEElement(offsetBits_interval(), 16);
    }

    /**
     * Set the value of the field 'interval'
     */
    public void set_interval(int value) {
        setUIntBEElement(offsetBits_interval(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'interval'
     */
    public static int size_interval() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'interval'
     */
    public static int sizeBits_interval() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: id
    //   Field type: int, unsigned
    //   Offset (bits): 32
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'id' is signed (false).
     */
    public static boolean isSigned_id() {
        return false;
    }

    /**
     * Return whether the field 'id' is an array (false).
     */
    public static boolean isArray_id() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'id'
     */
    public static int offset_id() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'id'
     */
    public static int offsetBits_id() {
        return 32;
    }

    /**
     * Return the value (as a int) of the field 'id'
     */
    public int get_id() {
        return (int)getUIntBEElement(offsetBits_id(), 16);
    }

    /**
     * Set the value of the field 'id'
     */
    public void set_id(int value) {
        setUIntBEElement(offsetBits_id(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'id'
     */
    public static int size_id() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'id'
     */
    public static int sizeBits_id() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: count
    //   Field type: int, unsigned
    //   Offset (bits): 48
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'count' is signed (false).
     */
    public static boolean isSigned_count() {
        return false;
    }

    /**
     * Return whether the field 'count' is an array (false).
     */
    public static boolean isArray_count() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'count'
     */
    public static int offset_count() {
        return (48 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'count'
     */
    public static int offsetBits_count() {
        return 48;
    }

    /**
     * Return the value (as a int) of the field 'count'
     */
    public int get_count() {
        return (int)getUIntBEElement(offsetBits_count(), 16);
    }

    /**
     * Set the value of the field 'count'
     */
    public void set_count(int value) {
        setUIntBEElement(offsetBits_count(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'count'
     */
    public static int size_count() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'count'
     */
    public static int sizeBits_count() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: readingsTemp
    //   Field type: int[], unsigned
    //   Offset (bits): 64
    //   Size of each element (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'readingsTemp' is signed (false).
     */
    public static boolean isSigned_readingsTemp() {
        return false;
    }

    /**
     * Return whether the field 'readingsTemp' is an array (true).
     */
    public static boolean isArray_readingsTemp() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'readingsTemp'
     */
    public static int offset_readingsTemp(int index1) {
        int offset = 64;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'readingsTemp'
     */
    public static int offsetBits_readingsTemp(int index1) {
        int offset = 64;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return offset;
    }

    /**
     * Return the entire array 'readingsTemp' as a int[]
     */
    public int[] get_readingsTemp() {
        int[] tmp = new int[2];
        for (int index0 = 0; index0 < numElements_readingsTemp(0); index0++) {
            tmp[index0] = getElement_readingsTemp(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'readingsTemp' from the given int[]
     */
    public void set_readingsTemp(int[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_readingsTemp(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a int) of the array 'readingsTemp'
     */
    public int getElement_readingsTemp(int index1) {
        return (int)getUIntBEElement(offsetBits_readingsTemp(index1), 16);
    }

    /**
     * Set an element of the array 'readingsTemp'
     */
    public void setElement_readingsTemp(int index1, int value) {
        setUIntBEElement(offsetBits_readingsTemp(index1), 16, value);
    }

    /**
     * Return the total size, in bytes, of the array 'readingsTemp'
     */
    public static int totalSize_readingsTemp() {
        return (32 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'readingsTemp'
     */
    public static int totalSizeBits_readingsTemp() {
        return 32;
    }

    /**
     * Return the size, in bytes, of each element of the array 'readingsTemp'
     */
    public static int elementSize_readingsTemp() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'readingsTemp'
     */
    public static int elementSizeBits_readingsTemp() {
        return 16;
    }

    /**
     * Return the number of dimensions in the array 'readingsTemp'
     */
    public static int numDimensions_readingsTemp() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'readingsTemp'
     */
    public static int numElements_readingsTemp() {
        return 2;
    }

    /**
     * Return the number of elements in the array 'readingsTemp'
     * for the given dimension.
     */
    public static int numElements_readingsTemp(int dimension) {
      int array_dims[] = { 2,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: readingsHum
    //   Field type: int[], unsigned
    //   Offset (bits): 96
    //   Size of each element (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'readingsHum' is signed (false).
     */
    public static boolean isSigned_readingsHum() {
        return false;
    }

    /**
     * Return whether the field 'readingsHum' is an array (true).
     */
    public static boolean isArray_readingsHum() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'readingsHum'
     */
    public static int offset_readingsHum(int index1) {
        int offset = 96;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'readingsHum'
     */
    public static int offsetBits_readingsHum(int index1) {
        int offset = 96;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return offset;
    }

    /**
     * Return the entire array 'readingsHum' as a int[]
     */
    public int[] get_readingsHum() {
        int[] tmp = new int[2];
        for (int index0 = 0; index0 < numElements_readingsHum(0); index0++) {
            tmp[index0] = getElement_readingsHum(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'readingsHum' from the given int[]
     */
    public void set_readingsHum(int[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_readingsHum(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a int) of the array 'readingsHum'
     */
    public int getElement_readingsHum(int index1) {
        return (int)getUIntBEElement(offsetBits_readingsHum(index1), 16);
    }

    /**
     * Set an element of the array 'readingsHum'
     */
    public void setElement_readingsHum(int index1, int value) {
        setUIntBEElement(offsetBits_readingsHum(index1), 16, value);
    }

    /**
     * Return the total size, in bytes, of the array 'readingsHum'
     */
    public static int totalSize_readingsHum() {
        return (32 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'readingsHum'
     */
    public static int totalSizeBits_readingsHum() {
        return 32;
    }

    /**
     * Return the size, in bytes, of each element of the array 'readingsHum'
     */
    public static int elementSize_readingsHum() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'readingsHum'
     */
    public static int elementSizeBits_readingsHum() {
        return 16;
    }

    /**
     * Return the number of dimensions in the array 'readingsHum'
     */
    public static int numDimensions_readingsHum() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'readingsHum'
     */
    public static int numElements_readingsHum() {
        return 2;
    }

    /**
     * Return the number of elements in the array 'readingsHum'
     * for the given dimension.
     */
    public static int numElements_readingsHum(int dimension) {
      int array_dims[] = { 2,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: readingsLum
    //   Field type: int[], unsigned
    //   Offset (bits): 128
    //   Size of each element (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'readingsLum' is signed (false).
     */
    public static boolean isSigned_readingsLum() {
        return false;
    }

    /**
     * Return whether the field 'readingsLum' is an array (true).
     */
    public static boolean isArray_readingsLum() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'readingsLum'
     */
    public static int offset_readingsLum(int index1) {
        int offset = 128;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'readingsLum'
     */
    public static int offsetBits_readingsLum(int index1) {
        int offset = 128;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return offset;
    }

    /**
     * Return the entire array 'readingsLum' as a int[]
     */
    public int[] get_readingsLum() {
        int[] tmp = new int[2];
        for (int index0 = 0; index0 < numElements_readingsLum(0); index0++) {
            tmp[index0] = getElement_readingsLum(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'readingsLum' from the given int[]
     */
    public void set_readingsLum(int[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_readingsLum(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a int) of the array 'readingsLum'
     */
    public int getElement_readingsLum(int index1) {
        return (int)getUIntBEElement(offsetBits_readingsLum(index1), 16);
    }

    /**
     * Set an element of the array 'readingsLum'
     */
    public void setElement_readingsLum(int index1, int value) {
        setUIntBEElement(offsetBits_readingsLum(index1), 16, value);
    }

    /**
     * Return the total size, in bytes, of the array 'readingsLum'
     */
    public static int totalSize_readingsLum() {
        return (32 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'readingsLum'
     */
    public static int totalSizeBits_readingsLum() {
        return 32;
    }

    /**
     * Return the size, in bytes, of each element of the array 'readingsLum'
     */
    public static int elementSize_readingsLum() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'readingsLum'
     */
    public static int elementSizeBits_readingsLum() {
        return 16;
    }

    /**
     * Return the number of dimensions in the array 'readingsLum'
     */
    public static int numDimensions_readingsLum() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'readingsLum'
     */
    public static int numElements_readingsLum() {
        return 2;
    }

    /**
     * Return the number of elements in the array 'readingsLum'
     * for the given dimension.
     */
    public static int numElements_readingsLum(int dimension) {
      int array_dims[] = { 2,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: readingsPhoto
    //   Field type: int[], unsigned
    //   Offset (bits): 160
    //   Size of each element (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'readingsPhoto' is signed (false).
     */
    public static boolean isSigned_readingsPhoto() {
        return false;
    }

    /**
     * Return whether the field 'readingsPhoto' is an array (true).
     */
    public static boolean isArray_readingsPhoto() {
        return true;
    }

    /**
     * Return the offset (in bytes) of the field 'readingsPhoto'
     */
    public static int offset_readingsPhoto(int index1) {
        int offset = 160;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return (offset / 8);
    }

    /**
     * Return the offset (in bits) of the field 'readingsPhoto'
     */
    public static int offsetBits_readingsPhoto(int index1) {
        int offset = 160;
        if (index1 < 0 || index1 >= 2) throw new ArrayIndexOutOfBoundsException();
        offset += 0 + index1 * 16;
        return offset;
    }

    /**
     * Return the entire array 'readingsPhoto' as a int[]
     */
    public int[] get_readingsPhoto() {
        int[] tmp = new int[2];
        for (int index0 = 0; index0 < numElements_readingsPhoto(0); index0++) {
            tmp[index0] = getElement_readingsPhoto(index0);
        }
        return tmp;
    }

    /**
     * Set the contents of the array 'readingsPhoto' from the given int[]
     */
    public void set_readingsPhoto(int[] value) {
        for (int index0 = 0; index0 < value.length; index0++) {
            setElement_readingsPhoto(index0, value[index0]);
        }
    }

    /**
     * Return an element (as a int) of the array 'readingsPhoto'
     */
    public int getElement_readingsPhoto(int index1) {
        return (int)getUIntBEElement(offsetBits_readingsPhoto(index1), 16);
    }

    /**
     * Set an element of the array 'readingsPhoto'
     */
    public void setElement_readingsPhoto(int index1, int value) {
        setUIntBEElement(offsetBits_readingsPhoto(index1), 16, value);
    }

    /**
     * Return the total size, in bytes, of the array 'readingsPhoto'
     */
    public static int totalSize_readingsPhoto() {
        return (32 / 8);
    }

    /**
     * Return the total size, in bits, of the array 'readingsPhoto'
     */
    public static int totalSizeBits_readingsPhoto() {
        return 32;
    }

    /**
     * Return the size, in bytes, of each element of the array 'readingsPhoto'
     */
    public static int elementSize_readingsPhoto() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of each element of the array 'readingsPhoto'
     */
    public static int elementSizeBits_readingsPhoto() {
        return 16;
    }

    /**
     * Return the number of dimensions in the array 'readingsPhoto'
     */
    public static int numDimensions_readingsPhoto() {
        return 1;
    }

    /**
     * Return the number of elements in the array 'readingsPhoto'
     */
    public static int numElements_readingsPhoto() {
        return 2;
    }

    /**
     * Return the number of elements in the array 'readingsPhoto'
     * for the given dimension.
     */
    public static int numElements_readingsPhoto(int dimension) {
      int array_dims[] = { 2,  };
        if (dimension < 0 || dimension >= 1) throw new ArrayIndexOutOfBoundsException();
        if (array_dims[dimension] == 0) throw new IllegalArgumentException("Array dimension "+dimension+" has unknown size");
        return array_dims[dimension];
    }

}