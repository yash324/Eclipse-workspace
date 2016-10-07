import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class A4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Name: ");
			Scanner in = new Scanner(System.in);
			String name = in.nextLine();
			File fp = new File(name);
			if (fp.isDirectory()) {
				System.out.println("Following are the contents of selected directory: ");
				String[] content = fp.list();
				System.out.println("Total Files/Folders in Directory = " + content.length);
				for (int i = 0; i < content.length; i++)
					System.out.println(content[i]);
				System.out.println("Press 1 to delete all text files");
				int ch = in.nextInt();
				in.close();
				if (ch == 1)
					for (int i = 0; i < content.length; i++)
						if (content[i].contains(".txt")) {
							File fdel = new File(name + "\\" + content[i]);
							fdel.delete();
						}
				System.out.println("New Content of Directory: ");
				content = fp.list();
				for (int i = 0; i < content.length; i++)
					System.out.println(content[i]);
				
			} else {
				System.out.println("INFO ABOUT THE FILE");
				System.out.println("Path: " + fp.getAbsolutePath());
				System.out.println("Size: " + fp.length() + "kB");
				System.out.println("Last Modified: " + new Date(fp.lastModified()).toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
