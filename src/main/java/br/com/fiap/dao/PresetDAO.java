package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.fiap.model.Preset;

public class PresetDAO implements Dao<Preset> {

	@Override
	public void cadastrar(Preset p) throws Exception {
		String sql = "insert into preset (nome, body, cor, decal, roda, boost, data_criacao)"
				+ " values(?, ?, ?, ?, ?, ?, CURRENT_DATE)";
		try (Connection con = new ConnectionFactory().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, p.getNome());
			pstmt.setString(2, p.getBody());
			pstmt.setString(3, p.getCor());
			pstmt.setString(4, p.getDecal());
			pstmt.setString(5, p.getRoda());
			pstmt.setString(6, p.getBoost());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void alterar(Preset p) throws Exception {
		String sql = "update preset set body=?, cor=?, decal=?, roda=?, boost=? where nome = ?";
		try (Connection con = new ConnectionFactory().getConexao();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, p.getBody());
			pstmt.setString(2, p.getCor());
			pstmt.setString(3, p.getDecal());
			pstmt.setString(4, p.getRoda());
			pstmt.setString(5, p.getBoost());
			pstmt.setString(6, p.getNome());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Preset consultaNome(String nome) throws Exception {
		String sql = "select * from preset where upper(nome) = ?";
		Preset p = null;
		try (Connection con = new ConnectionFactory().getConexao();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, nome.toUpperCase());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (p == null) {
					p = new Preset();
					p.setId(rs.getLong("id"));
					p.setNome(rs.getString("nome"));
					p.setBody(rs.getString("body"));
					p.setCor(rs.getString("cor"));
					p.setDecal(rs.getString("decal"));
					p.setRoda(rs.getString("roda"));
					p.setBoost(rs.getString("boost"));
					p.setDataCriacao(rs.getDate("data_criacao").toLocalDate());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return p;
	}
	
	public ArrayList<String> getPresets() throws Exception {
		String sql = "select nome from preset";
		ArrayList<String> presets = new ArrayList<String>();
		Preset p = null;
		try (Connection con = new ConnectionFactory().getConexao();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {				
				presets.add(rs.getString("nome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return presets;
	}

}
