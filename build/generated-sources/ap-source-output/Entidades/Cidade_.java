package Entidades;

import Entidades.Pais;
import Entidades.Place;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-28T20:01:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cidade.class)
public class Cidade_ { 

    public static volatile SingularAttribute<Cidade, String> nomeCidade;
    public static volatile ListAttribute<Cidade, Place> placeList;
    public static volatile SingularAttribute<Cidade, Integer> idcidade;
    public static volatile SingularAttribute<Cidade, Pais> paisIdpais;

}