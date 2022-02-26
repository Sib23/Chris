import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Random r = new Random ();
	
	Scanner scan = new Scanner (System.in);
	
	Vector<String> NamaKaryawan = new Vector<String>();
	Vector<String> JKKaryawan = new Vector<String>();
	Vector<String> JabKaryawan= new Vector<String>();
	Vector<String> IdK= new Vector<String>();
	Vector<Integer> GajiKaryawan = new Vector<Integer>();
	
	String name, jk, jab, id1;
	Integer id2;
	
	public Main() {
		while (true) {
			int input = 0 ; 
			System.out.println("PT Musang");
			System.out.println("===============");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan ");
			System.out.println("4. Delete Data Karyawan");
			System.out.print(">>");
			input = scan.nextInt();scan.nextLine();
			
			switch (input) {
			case 1:
				Idk();
				break;

			case 2 :
				if(NamaKaryawan.isEmpty() && JKKaryawan.isEmpty() && JabKaryawan.isEmpty() && GajiKaryawan.isEmpty()) {
					System.out.println("Belum ada Data yang Di Input");
				}else {
					sort();
					viewD();
				}
				
				break;
				
			case 3 :
				if(NamaKaryawan.isEmpty() && JKKaryawan.isEmpty() && JabKaryawan.isEmpty() && GajiKaryawan.isEmpty()) {
					System.out.println("Belum ada Data yang Di Input");
				
				}else {
					
				UpdateD();
				
				}
				
				break;
				
			case 4 :
				if(NamaKaryawan.isEmpty() && JKKaryawan.isEmpty() && JabKaryawan.isEmpty() && GajiKaryawan.isEmpty()) {
					System.out.println("Belum ada Data yang Di Input");
				}else {
				DeleteD();
				}
				break;
			}
			
		}
	}

	private void UpdateD() {
		sort();
		viewD();
		
		String  newName, newJK, newJab;
		Integer input, newgaji;
		
		do {
			System.out.println("Input Nomor Urutan Karyawan yang ingin diupdate :");
			input = scan.nextInt(); scan.nextLine();	
		} while (input < 0 && input > NamaKaryawan.size());
		
	
		
		do {
			System.out.println("Input Nama Karyawan :");
			newName = scan.nextLine();
			
			if(newName.length()>3) {
			
				NamaKaryawan.set(input-1, newName);
				
			}else if(newName.equals("0")) {
				
			}
			
		} while (!(newName.length() < 3 || newName.equals("0")));
		
		
		
		do {
			System.out.println("Input Jenis Kelamin Karyawan [Laki - Laki / Perempuan]:");
			newJK = scan.nextLine();
			
			if(newJK.equals ("Laki - Laki") && !newJK.equals ("Perempuan")) { 
				
				JKKaryawan.set(input-1, newJK);
				
			}else if (newJK.equals("0")) {
				
			}
			
		} while (!newJK.equals ("Laki - Laki") && !newJK.equals ("Perempuan"));
		
		
		
		do {
			System.out.println("Input Jabatan Karyawan [Manager/ Supervisor/ Admin] :");
			newJab = scan.nextLine();
			
			if (newJab.equals ("Manager") && newJab.equals ("Supervisor") && newJab.equals ("Admin")) {
				
				JabKaryawan.set(input-1, newJab);
				
			}else if (newJab.equals("0")) {
				
			}
			
			
		} while (!newJab.equals ("Manager") 
				&& !newJab.equals ("Supervisor") 
				&& !newJab.equals ("Admin"));
		
	
		if (newJab.equals ("Manager")) {
			newgaji = 8000000;
		}else if (newJab.equals ("Supervisor")) {
			newgaji = 6000000;
		}else {
			newgaji = 4000000;
		}
		
		GajiKaryawan.set(input-1, newgaji);
	
		
		System.out.println("Berhasil Mengupdate Data Karyawan dengan  ID : " + IdK);
	}

	private void DeleteD() {
		sort();
		viewD();
		
		Integer input;
		
		do {
			System.out.println("Input Nomor Urutan Karyawan yang ingin dihapus : ");
			input = scan.nextInt(); scan.nextLine();
			
		} while (input < 0 && input > NamaKaryawan.size());
		
			NamaKaryawan.remove(input - 1);
			JKKaryawan.remove(input - 1);
			JabKaryawan.remove(input - 1);
			GajiKaryawan.remove(input - 1);
			IdK.remove(input - 1);
			
		
		}

	
	

	private void sort() {
		for (int i = 0; i < NamaKaryawan.size(); i++) {
			for (int j = i+1; j < NamaKaryawan.size(); j++) {
				if (NamaKaryawan.get(i).toCharArray()[0] 
						> NamaKaryawan.get(j).toCharArray()[0]) {
					
					
					String tempName = NamaKaryawan.get(i);
					String tempJK= JKKaryawan.get(i);
					String tempJab =JabKaryawan.get(i);
					Integer tempGaji = GajiKaryawan.get(i);
					String tempid = IdK.get(i);
				
					
					NamaKaryawan.set(i,NamaKaryawan.get(j));
					JKKaryawan.set(i,JKKaryawan.get(j));
					JabKaryawan.set(i,JabKaryawan.get(j));
					GajiKaryawan.set(i,GajiKaryawan.get(j));
					IdK.set(i,IdK.get(j));
				
					
					NamaKaryawan.set(j,tempName);
					JKKaryawan.set(j,tempJK);
					JabKaryawan.set(j,tempJab);
					GajiKaryawan.set(j,tempGaji);
					IdK.set(j,tempid);
					
		
				
			}
		}
	}
				
	}

	private void viewD() {
		
		for (int i = 0; i < NamaKaryawan.size(); i++) {
			
			System.out.println((i+1)+".  Nama Karyawan : ");
			System.out.println(NamaKaryawan.get(i));
			
			System.out.println(" Jenis Kelamin : ");
			System.out.println(JKKaryawan.get(i));
			
			System.out.println(" Jabatan Karyawan : ");
			System.out.println(JabKaryawan.get(i));
			
			System.out.println(" Gaji Karyawan : ");
			System.out.println(JabKaryawan.get(i));
			
			System.out.println(" ID Karyawan : ");
			System.out.println(IdK.get(i));
			System.out.println("");		
	}
	}
		
		
		
	private void Idk() {
		
		int gaji;
		int min = 1000;
		int max = 9999;
		int range = max - min + 1 ;
		int dom = ((int) (Math.random()*range)+ min );
		
		String x1 = Character.toString( (char) ('A' + r.nextInt(26)));
		String x2 = Character.toString( (char) ('A' + r.nextInt(26)));
		
		do {
			System.out.println("Input Nama Karyawan :");
			name = scan.nextLine();
		} while (name.length() < 3);
		
		
		do {
			System.out.println("Input Jenis Kelamin Karyawan [Laki - Laki / Perempuan]:");
			jk = scan.nextLine();
		} while (!jk.equals ("Laki - Laki") && !jk.equals ("Perempuan"));
		
		
		do {
			System.out.println("Input Jabatan Karyawan [Manager/ Supervisor/ Admin] :");
			jab = scan.nextLine();
		} while (!jab.equals ("Manager") 
				&& !jab.equals ("Supervisor") 
				&& !jab.equals ("Admin"));
		
		if (jab.equals ("Manager")) {
			gaji = 8000000;
		}else if (jab.equals ("Supervisor")) {
			gaji = 6000000;
		}else {
			gaji = 4000000;
		}
		
		id1 = x1 + x2;
		id2 = dom;
		String id3 = id1 +"-"+ id2;
		System.out.println("Berhasil Menambahkan Karyawan Dengan ID : " + id3);
		System.out.println("Press Enter to Return");
		
		NamaKaryawan.add(name);
		JKKaryawan.add(jk);
		JabKaryawan.add(jab);
		GajiKaryawan.add(gaji);
		IdK.add(id3);
	
	
		
		scan.nextLine();
	
			
		}
	

	public static void main(String[] args) {
		new Main ();
	}

}
