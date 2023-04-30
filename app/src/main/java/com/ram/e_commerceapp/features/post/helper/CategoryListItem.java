package com.ram.e_commerceapp.features.post.helper;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CategoryListItem implements Serializable {
	@SerializedName("image")
	public String image;
	@SerializedName("name")
	public String name;
	@SerializedName("id")
	public long id;

	public String getImage(){
		return image;
	}
	public String getName(){
		return name;
	}
	public long getId(){
		return id;
	}
}
