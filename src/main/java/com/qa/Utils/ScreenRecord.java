package com.qa.Utils;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;


public class ScreenRecord extends ScreenRecorder  {
	
		public static ScreenRecorder screenRecorder;


		private ScreenRecord(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
				Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
			super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
			
		}

		
		@Override
		protected File createMovieFile(Format fileFormat) throws IOException {
			if (!movieFolder.exists()) {
				movieFolder.mkdirs();
			} else if (!movieFolder.isDirectory()) {
				throw new IOException("\"" + movieFolder + "\" is not a directory.");
			}
			return new File(movieFolder, "FMS V14 Uyeno Automation recording_"+ TestUtils.getDate() + "." + Registry.getInstance().getExtension(fileFormat));
		}

		
		// This method is used to record the screen while test execution
		public static void startRecording(String methodName) {
			File file = new File("./Recordings/");
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = screenSize.width;
			int height = screenSize.height;

			Rectangle captureSize = new Rectangle(0, 0, width, height);

			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
					getDefaultScreenDevice()
					.getDefaultConfiguration();

			try {
				screenRecorder = new ScreenRecord(gc, captureSize,
						new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
						new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
								CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
								Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
						new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
						null, file, methodName);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			
			try {
			screenRecorder.start();
			} catch (Exception e) {
			System.out.println("Error in starting the video");
			}
		}

		
		public static void stopRecording() {
			try {
				screenRecorder.stop();
			} catch (IOException e) {
				System.out.println("Unable to stop the screen recording");
			}
		}

}
