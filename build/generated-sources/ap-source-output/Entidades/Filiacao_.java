package Entidades;

import Entidades.Personagem;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-28T20:01:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Filiacao.class)
public class Filiacao_ { 

    public static volatile ListAttribute<Filiacao, Personagem> personagemList;
    public static volatile SingularAttribute<Filiacao, String> descFiliacao;
    public static volatile SingularAttribute<Filiacao, String> filiacao;
    public static volatile SingularAttribute<Filiacao, Integer> idfiliacao;

}