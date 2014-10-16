package simpleTests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.IIOImage;

import net.sourceforge.tess4j.TessAPI;
import net.sourceforge.tess4j.TessAPI.TessBaseAPI;
import net.sourceforge.tess4j.TessAPI.TessOcrEngineMode;
import net.sourceforge.tess4j.TessAPI.TessPageSegMode;
import net.sourceforge.vietocr.ImageIOHelper;

public class DetailedTest {
	public static void main(String[] args) {
		TessAPI api = TessAPI.INSTANCE;
		TessBaseAPI handle = api.TessBaseAPICreate();
		api.TessBaseAPIInit2(handle, "./", "eng", TessOcrEngineMode.OEM_TESSERACT_CUBE_COMBINED);
		api.TessBaseAPISetPageSegMode(handle, TessPageSegMode.PSM_AUTO);
		
		
		URL resource = TestTesseract.class.getClassLoader()//
//				.getResource("images.jpg");
				.getResource("Test2.png");
//				.getResource("Test5.png");

		File f = new File(resource.getFile());
		
		try {
			List<IIOImage> iioImageList = ImageIOHelper.getIIOImageList(f);
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
