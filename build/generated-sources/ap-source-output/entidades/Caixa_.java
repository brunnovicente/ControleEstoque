package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Caixa.class)
public abstract class Caixa_ {

	public static volatile SingularAttribute<Caixa, Date> datainicio;
	public static volatile SingularAttribute<Caixa, Date> datafinal;
	public static volatile SingularAttribute<Caixa, Double> vendido;
	public static volatile SingularAttribute<Caixa, Integer> id;
	public static volatile SingularAttribute<Caixa, String> status;

}

