/*
 * Copyright 2007 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ce.book.manager;

import java.util.Hashtable;

/**
 * Implementations of this interface can decode an image of a barcode in some format into
 * the String it encodes. For example, {@link ce.book.manager.qrcode.QRCodeReader} can
 * decode a QR code. The decoder may optionally receive hints from the caller which may help
 * it decode more quickly or accurately.
 *
 * See {@link ce.book.manager.MultiFormatReader}, which attempts to determine what barcode
 * format is present within the image as well, and then decodes it accordingly.
 *
 * @author Sean Owen
 * @author dswitkin@google.com (Daniel Switkin)
 */
public interface Reader {

  /**
   * Locates and decodes a barcode in some format within an image.
   *
   * @param image image of barcode to decode
   * @return String which the barcode encodes
   * @throws NotFoundException if the barcode cannot be located or decoded for any reason
   */
  Result decode(BinaryBitmap image) throws NotFoundException, ChecksumException, FormatException;

  /**
   * Locates and decodes a barcode in some format within an image. This method also accepts
   * hints, each possibly associated to some data, which may help the implementation decode.
   *
   * @param image image of barcode to decode
   * @param hints passed as a {@link java.util.Hashtable} from {@link ce.book.manager.DecodeHintType}
   * to arbitrary data. The
   * meaning of the data depends upon the hint type. The implementation may or may not do
   * anything with these hints.
   * @return String which the barcode encodes
   * @throws NotFoundException if the barcode cannot be located or decoded for any reason
   */
  Result decode(BinaryBitmap image, Hashtable hints) throws NotFoundException, ChecksumException, FormatException;

  /**
   * Resets any internal state the implementation has after a decode, to prepare it
   * for reuse.
   */
  void reset();

}
//테스트 주석 추가