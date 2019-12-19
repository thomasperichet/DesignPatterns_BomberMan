package Game;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import externals.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ViewCommand vc = new ViewCommand();

		//SimpleGame sg1 = new SimpleGame(50);
		/*JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);
		File selectedFile = jfc.getSelectedFile();

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			System.out.println(selectedFile.getAbsolutePath());
		}
		*/
		@SuppressWarnings("unused")
		Map map1;
		try {
			map1 = new Map("src/layouts/niveau3.lay");
			BombermanGame bg = new BombermanGame(1000,map1);
			try {
				ControleurBombermanGame cbg = new ControleurBombermanGame(bg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		

		/*
		SimpleGame sg1 = new SimpleGame(50);
		ControleurSimpleGame csg = new ControleurSimpleGame(sg1);
		*/
		
		/*
		sg1.init();
		sg1.run();
		sg1.step();
		*/
		
	}

}
