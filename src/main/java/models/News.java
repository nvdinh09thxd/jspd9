package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
	private int id;
	private String name;
	private String description;
	private String images;
	private String details;
	private  String created_at;
	private String cat_id;
}
