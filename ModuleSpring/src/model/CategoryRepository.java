package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CategoryRepository extends Repository {
	public List<Category> getAll() {
		RowMapper<Category> mapper = new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setParent(rs.getInt(3));
				return category;
			}
		};
		return jdbc.query("SELECT * FROM category", mapper);

	}

	public List<Category> getListParent() {
		RowMapper<Category> mapper = new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setParent(rs.getInt(3));
				return category;
			}
		};
		return jdbc.query("SELECT * FROM category WHERE ParentId IS null", mapper);

	}

	public int add(Category obj) {
		return jdbc.update("INSERT INTO category (CategoryName,ParentId) VALUES(?,?)", obj.getName(), obj.getParent());
	}

	public Category findById(int id) {
		RowMapper<Category> mapper = new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setParent(rs.getInt(3));
				return category;
			}
		};
		return jdbc.queryForObject("SELECT * FROM category WHERE CategoryId =?", mapper, id);

	}
	public int edit(Category category) {
		return jdbc.update("UPDATE category SET CategoryName = ? , ParentId = ? WHERE CategoryId=?",category.getName(),category.getParent(),category.getId());
		
	}

}
