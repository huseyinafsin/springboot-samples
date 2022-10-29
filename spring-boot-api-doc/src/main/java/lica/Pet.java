package lica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Benim Pet Nesnem", description = "Benim pet açıklamam")
public class Pet {

    @ApiModelProperty(value = "id property")
    private int id;


    @ApiModelProperty(value = "name property")
    private String name;

    @ApiModelProperty(value = "date property")
    private Date date;
}
