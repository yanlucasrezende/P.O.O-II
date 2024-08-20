package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {

	Connection con;
	String sql;
	PreparedStatement pst;
	
	public void fecharConexaoPst() {
		try {
			pst.close();
		} catch (Exception e) {
		}
	}

	public void salvar(Aluno a) throws SQLException {

		try {
			con = db.getConexao();
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?,?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			Date dataSql = Date.valueOf(a.getDt_nasc());
			pst.setDate(3, dataSql);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//pst.close();
		}
	}

	public List<Aluno> listar() throws Exception {
		try {
			List<Aluno> listaAluno = new ArrayList<Aluno>();
			con = db.getConexao();
			sql = "select * from aluno";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Aluno a = new Aluno();

				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setSexo(rs.getString(3));
				a.setDt_nasc(rs.getDate(4).toLocalDate());
				
				listaAluno.add(a);
			}
			return listaAluno;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//pst.close();
		}
		return new ArrayList<Aluno>();
	}

	public void apagar(int id) throws Exception {
		try {
			con = db.getConexao();
			sql = "delete from aluno where id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("\nAluno excluido com sucesso!");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//pst.close();
		}
	}

	public void alterar(int id, String nome, String sexo, LocalDate data) throws Exception{
		try {
			try {
				con = db.getConexao();
				sql = "UPDATE aluno  SET nome = ? , sexo = ?, dt_nasc = ? WHERE id = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, nome);
				pst.setString(2, sexo);
				Date dataSql = Date.valueOf(data);
				pst.setDate(3, dataSql);
				pst.setInt(4, id);
				pst.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				//pst.close();
			}
		} catch (Exception e) {
		
		}
	}
}
