package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class ProductRepository extends Repository {
	public List<Product> getAll(int index, int size) {
		RowMapper<Product> rowMapper = new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
				return product;
			}
		};
		return jdbc.query("SELECT * FROM product LIMIT ?,?", rowMapper, (index - 1) * size, size);
	}
	public List<Product> getAll(int index, int size,String search) {
		RowMapper<Product> rowMapper = new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
				return product;
			}
		};
		return jdbc.query("SELECT * FROM product WHERE Title LIKE ? LIMIT ?,?", rowMapper,search, (index - 1) * size, size);
	}

	public int count() {
		return jdbc.queryForObject("SELECT COUNT(*) AS Total FROM Product", new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException {
				return rs.getInt("Total");
			}
		});
	}

	public Product getById(int id) {
		RowMapper<Product> rowMapper = new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product(rs.getInt("ProductId"), rs.getString("Title"), rs.getString("ISBN"),
						rs.getInt("Price"), rs.getString("Pages"), rs.getString("ImageUrl"));
				return product;
			}
		};
		return jdbc.queryForObject("SELECT * FROM product WHERE ProductId=?", rowMapper, id);
	}
}
