package simpleTests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.IIOImage;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.vietocr.ImageIOHelper;

public class TestTesseract {
	public static void main(String[] args) {
		URL resource = TestTesseract.class.getClassLoader()//
//				.getResource("images.jpg");
				.getResource("bluredimage.jpg");
//				.getResource("Test5.png");

		File f = new File(resource.getFile());

		try {
			Tesseract instance = Tesseract.getInstance();
//			Tesseract1 instance = new Tesseract1();
			String doOCR = instance.doOCR(f);
			System.out.println(doOCR);
		} catch (TesseractException e) {
			e.printStackTrace();
		}
	}
}
