package com.techelevator.model.foodmenu;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcFoodMenuItemDAO implements FoodMenuItemDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcFoodMenuItemDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<FoodMenuItem> getFoodMenuById(int menuId) {
		
		String sqlQuery = "SELECT menu_item_id, name, description, menu_id, "
				+ "menu_item.food_category_id, category_name FROM menu_item "
				+ "INNER JOIN food_category ON food_category.food_category_id = menu_item.food_category_id "
				+ "WHERE menu_id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, menuId);
		
		List<FoodMenuItem> foodMenu = new ArrayList<>();
		while (results.next()) {
			foodMenu.add(mapToFoodMenuItem(results));
		}
		return foodMenu;
	}

	@Override
	public void saveFoodMenuItem(FoodMenuItem menuItem) {
		String sqlInsert = "INSERT INTO menu_item (menu_id, name, description, food_category_id)"
				+ " VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsert, menuItem.getMenuId(), menuItem.getName(),
				menuItem.getDescription(), menuItem.getFoodCategoryId());
	}
	
	@Override
	public List<FoodCategory> getFoodCategories(){
		
		String sqlQuery = "SELECT * FROM food_category";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
		
		List<FoodCategory> foodCatList = new ArrayList<FoodCategory>();
		while(results.next()) {
			FoodCategory foodCat = new FoodCategory();
			foodCat.setFoodCategoryId(results.getInt("food_category_id"));
			foodCat.setFoodType(results.getString("category_name"));
			
			foodCatList.add(foodCat);
		}
		
		return foodCatList;
	}
	
	public void deleteFoodMenuItem(int foodMenuItemId) {
		
		String sqlDeleteFirst = "DELETE FROM food_orders WHERE menu_item_id = ?;";

		String sqlDelete = "DELETE FROM menu_item WHERE menu_item_id = ?;";
		
		jdbcTemplate.update(sqlDeleteFirst, foodMenuItemId);
		
		jdbcTemplate.update(sqlDelete, foodMenuItemId);
	}
	
	public FoodMenuItem getFoodMenuItemById(int foodMenuItemId) {
		String sqlQuery = "SELECT menu_item_id, name, description, menu_id, "
				+ "menu_item.food_category_id, category_name FROM menu_item "
				+ "INNER JOIN food_category ON food_category.food_category_id = menu_item.food_category_id "
				+ "WHERE menu_item_id=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, foodMenuItemId);
		
		FoodMenuItem foodMenuItem = null;
		if(results.next()) {
			foodMenuItem = mapToFoodMenuItem(results);
		}
		return foodMenuItem;
	}
	
	private FoodMenuItem mapToFoodMenuItem(SqlRowSet results) {
		
		FoodMenuItem menuItem = new FoodMenuItem();
		
		menuItem.setMenuItemId(results.getInt("menu_item_id"));
		menuItem.setMenuId(results.getInt("menu_id"));
		menuItem.setName(results.getString("name"));
		menuItem.setDescription(results.getString("description"));
		menuItem.setFoodCategoryId(results.getInt("food_category_id"));
		menuItem.setFoodCategory(results.getString("category_name"));
		
		return menuItem;
	}
	
	

}
