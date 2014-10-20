package simpleTests;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;

import javax.imageio.IIOImage;

import net.sourceforge.tess4j.TessAPI;
import net.sourceforge.tess4j.TessAPI.TessBaseAPI;
import net.sourceforge.tess4j.TessAPI.TessOcrEngineMode;
import net.sourceforge.vietocr.ImageHelper;
import net.sourceforge.vietocr.ImageIOHelper;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class DetailedTest {
	public static void main(String[] args) throws IOException {
		TessAPI api = TessAPI.INSTANCE;
		TessBaseAPI handle = api.TessBaseAPICreate();
		ImageHelper ih = new ImageHelper();
		ImageIOHelper iio = new ImageIOHelper();
		api.TessBaseAPIInit2(handle, "./", "eng", TessOcrEngineMode.OEM_TESSERACT_CUBE_COMBINED);
//		api.TessBaseAPISetPageSegMoTessBaseAPIAdaptToWordStrde(handle, TessPageSegMode.PSM_AUTO);
		
		URL resource = TestTesseract.class.getClassLoader()//
//				.getResource("images.jpg");
				.getResource("character/1.png");
//				.getResource("Test5.png");

		File f = new File(resource.getFile());

		List<IIOImage> imageList = ImageIOHelper.getIIOImageList(f);
		RenderedImage rimage = null;
		for (IIOImage oimage : imageList) {
			rimage = oimage.getRenderedImage();
		}
		int width = rimage.getWidth();
		int height = rimage.getHeight();
		int bpp = rimage.getColorModel().getPixelSize();
		int bytespp = bpp / 8;
		int bytespl = (int) Math.ceil(width * bpp / 8.0);
		ByteBuffer bb2 =  ImageIOHelper.getImageByteBuffer(rimage);
//		BufferedImage bi = ImageIO.read(f);
//		BufferedImage bi2 = new BufferedImage(bi.getWidth(),
//				bi.getHeight(), BufferedImage.TYPE_INT_ARGB);
//		BufferedImage binary = ih.convertImage2Binary(bi2);
//		ByteBuffer bb = iio.convertImageData(binary);
	 	
	 	api.TessBaseAPISetImage(handle, bb2, width, height, bytespp, bytespl);
	 	Pointer p = api.TessBaseAPIGetUTF8Text(handle);
//	 	int confidence = api.TessBaseAPIAdaptToWordStr(handle, 0, p.getString(0));
	 	IntByReference tesseractPoint = api.TessBaseAPIAllWordConfidences(handle);
	 	Pointer pointer = tesseractPoint.getPointer();
	 	
	 	for(int i=0; i<pointer.SIZE; i++) {
	 		System.out.println(pointer.getString(i));
	 	}
	 	
	 	String str = p.getString(0);
	 	System.out.println(str);
	}
}
