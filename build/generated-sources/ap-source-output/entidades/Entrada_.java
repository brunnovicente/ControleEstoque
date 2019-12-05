package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Entrada.class)
public abstract class Entrada_ {

	public static volatile SingularAttribute<Entrada, Date> data;
	public static volatile SingularAttribute<Entrada, Produto> produto;
	public static volatile SingularAttribute<Entrada, Usuario> usuario;
	public static volatile SingularAttribute<Entrada, Integer> id;
	public static volatile SingularAttribute<Entrada, Integer> quantidade;

}

