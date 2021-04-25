package cn.wjs.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;


@Data
@ToString
@NoArgsConstructor
public class EsModel {

    private String id;

    private String name;

    private int age;

    private Date date;
}
