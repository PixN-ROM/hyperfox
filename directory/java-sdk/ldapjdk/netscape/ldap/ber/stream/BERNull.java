/* -*- Mode: C++; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * The contents of this file are subject to the Netscape Public License
 * Version 1.0 (the "NPL"); you may not use this file except in
 * compliance with the NPL.  You may obtain a copy of the NPL at
 * http://www.mozilla.org/NPL/
 *
 * Software distributed under the NPL is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the NPL
 * for the specific language governing rights and limitations under the
 * NPL.
 *
 * The Initial Developer of this code under the NPL is Netscape
 * Communications Corporation.  Portions created by Netscape are
 * Copyright (C) 1999 Netscape Communications Corporation.  All Rights
 * Reserved.
 */
package netscape.ldap.ber.stream;

import java.util.*;
import java.io.*;

/**
 * This class is for the NULL type.
 *
 * <pre>
 * ENCODING RULE:
 *   tag = 0x05
 *   length value is zero (short or long form).
 *   no contents
 *
 * Example 1:  (short form)
 *   05 00
 * Example 2:  (long form)
 *   05 81 00
 * </pre>
 *
 * @version 1.0
 * @seeAlso CCITT X.209
 */
public class BERNull extends BERElement {
    /**
     * Constructs a NULL element.
     */
    public BERNull() {
    }

    /**
     * Constructs a null element from an input stream.
     * @param stream input stream from socket
     * @param bytes_read array of 1 int; value incremented by
     *        number of bytes read from stream
     * @exception IOException failed to construct
     */
    public BERNull(InputStream stream, int[] bytes_read) throws IOException {
        /* The result should be zero of course */
        readLengthOctets(stream,bytes_read);
    }

    /**
     * Sends the BER encoding directly to stream.
     * @param stream output stream
     * @exception IOException failed to write
     */
    public void write(OutputStream stream) throws IOException {
        byte[] buffer = new byte[2];
        buffer[0] = (byte)BERElement.NULL;  /* NULL tag */
        buffer[1] = 0x00;  /* length */
        stream.write(buffer);
    }

    /**
     * Gets the element type.
     * @return element type
     */
    public int getType() {
        return BERElement.NULL;
    }

    /**
     * Gets the string representation.
     * @return string representation of tag
     */
    public String toString() {
        return "Null {}";
    }
}
