package com.hexaware.player.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerDTO {
	
	@NotBlank(message="Player name should not be empty.")
	@Size(min=3,max=20)
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$",message = "Player name must start with a capital letter")
	private String playername;
	
	@NotNull(message="jersey number should not be empty.")
	@Positive(message="Number should be positve.")
	@Min(value=1)
	@Max(value=999)
	private int jnumber;
	
	@NotBlank(message="Role should not be empty.")
	@Size(min=3,max=20)
	@Pattern(regexp =  "^[A-Z ]+$",message = "Role should always be capital letter.")
	private String role;
	
	@NotNull(message="Total matches should not be empty.")
	@Positive(message="Number should be positve.")
	@Min(value=0)
	@Max(value=9999)
	private int tolmatches;
	
	@NotBlank(message="Team name should not be empty.")
	@Size(min=2,max=30)
	@Pattern(regexp = "^[A-Z][a-zA-Z ]*$",message = "Team name must start with a capital letter")
	private String teamname;
	
	@NotBlank(message="Country/State name should not be empty.")
	@Size(min=3,max=20)
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$",message = "Country/State name must start with a capital letter")
	private String countryname;
	
	@NotBlank(message="Team name should not be empty.")
	@Size(min=2,max=200)
	@Pattern(regexp = "^[A-Z][a-zA-Z ]*$",message = "Team name must start with a capital letter")
	private String description;
}
