package br.com.fiap.bo;

import br.com.fiap.dao.PresetDAO;
import br.com.fiap.model.Preset;

public class PresetBO {
	
	public boolean cadastrar(Preset p) throws Exception {
		PresetDAO dao = new PresetDAO();
		try {
			Preset preset = dao.consultaNome(p.getNome());
			if (preset == null) {
				dao.cadastrar(p);
				System.out.println("Preset registrada com sucesso!");
				return true;
			} else
				System.out.println("Já existe uma preset com esse nome!");
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean alterar(Preset p) throws Exception {
		PresetDAO dao = new PresetDAO();
		try {	
			dao.alterar(p);
			System.out.println("Preset alterada com sucesso!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Preset consultaNome(String nome) throws Exception {
		PresetDAO dao = new PresetDAO();
		Preset p = null;
		try {	
			if (nome != null)
				p = dao.consultaNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return p;
	}
	
}
