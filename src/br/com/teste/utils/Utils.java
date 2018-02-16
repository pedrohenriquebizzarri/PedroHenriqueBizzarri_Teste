package br.com.teste.utils;

import br.com.teste.to.Sexo;

public class Utils {
	public String inverteData(String data) {
		return data.substring(6, 10) + "/" + data.substring(3, 5) + "/" + data.charAt(0) + data.charAt(1);
	}

	public String formataData(String data) {
		return data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.charAt(1) + data.substring(1, 4);
	}

	public int formataSexoParaInt(Sexo sexo) {
		if (sexo == Sexo.MASCULINO) {
			return 1;
		} else {
			return 2;
		}
	}

	public Sexo formataIntParaSexo(int num) {
		if (num == 1) {
			return Sexo.MASCULINO;
		} else {
			return Sexo.FEMININO;
		}
	}

	public Sexo formataStringParaSexo(String sexo) {
		if (sexo.equals("Masculino")) {
			return Sexo.MASCULINO;
		} else {
			return Sexo.FEMININO;
		}
	}

	public int formataBooleanParaInt(boolean b) {
		if (b == true) {
			return 1;
		} else {
			return 0;
		}
	}

	public boolean formataIntParaBoolean(int num) {
		if (num == 1) {
			return true;
		} else {
			return false;
		}
	}
}
