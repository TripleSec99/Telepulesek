public class Telepulesek {
	private String irsz;
	private String név;
	private String kerület;
	private String megyekód;
	private double lat;
	private double lon;
	private String ksh;
	private int jogállás;
	private int terület;
	private int népesség;
	private int lakások;

	public Telepulesek(String line) {
		String[] parts = line.split("\t");

		if (parts.length != 10) {
			System.out.println("Hiba a fájlban! Sor adatai: irsz=" + parts[0] + "elemszám: " + parts.length);
			return;
		}

		irsz = parts[0].trim();
		String tmp = parts[1].trim();
		if (tmp.startsWith("Budapest")) {
			név = "Budapest";
			kerület = tmp.substring(9).trim();
		} else {
			név = tmp;
		}
		megyekód = parts[2].trim();
		lat = Double.parseDouble(parts[3].trim());
		lon = Double.parseDouble(parts[4].trim());
		ksh = parts[5].trim();
		jogállás = Integer.parseInt(parts[6].trim());
		terület = Integer.parseInt(parts[7].trim());
		népesség = Integer.parseInt(parts[8].trim());
		lakások = Integer.parseInt(parts[9].trim());
	}

	public String getIrsz() {
		return irsz;
	}

	public void setIrsz(String irsz) {
		this.irsz = irsz;
	}

	public String getNév() {
		return név;
	}

	public void setNév(String név) {
		this.név = név;
	}

	public String getKerület() {
		return kerület;
	}

	public void setKerület(String kerület) {
		this.kerület = kerület;
	}

	public String getMegyekód() {
		return megyekód;
	}

	public void setMegyekód(String megyekód) {
		this.megyekód = megyekód;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getKsh() {
		return ksh;
	}

	public void setKsh(String ksh) {
		this.ksh = ksh;
	}

	public int getJogállás() {
		return jogállás;
	}

	public void setJogállás(int jogállás) {
		this.jogállás = jogállás;
	}

	public int getTerület() {
		return terület;
	}

	public void setTerület(int terület) {
		this.terület = terület;
	}

	public int getNépesség() {
		return népesség;
	}

	public void setNépesség(int népesség) {
		this.népesség = népesség;
	}

	public int getLakások() {
		return lakások;
	}

	public void setLakások(int lakások) {
		this.lakások = lakások;
	}

	@Override
	public String toString() {
		return "Telepulesek{" + "irsz=" + irsz + ", n\u00e9v=" + név + ", ker\u00fclet=" + kerület + ", megyek\u00f3d="
				+ megyekód + ", lat=" + lat + ", lon=" + lon + ", ksh=" + ksh + ", jog\u00e1ll\u00e1s=" + jogállás
				+ ", ter\u00fclet=" + terület + ", n\u00e9pess\u00e9g=" + népesség + ", lak\u00e1sok=" + lakások + '}';
	}

}
