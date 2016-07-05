
package it.engim.templatedb;




import it.engim.teamplatedb.beans.TariffeCorriere;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

public class TariffeCorriereDataProvider extends SortableDataProvider<TariffeCorriere, String>
{

  @Override
  public Iterator<? extends TariffeCorriere> iterator(long first, long count)
  {
    EntityManager em = PM.getEM();
    try
    {
      Query q = em.createNamedQuery("TariffeCorriere.findAll");
      q.setFirstResult((int) first);
      q.setMaxResults((int) count);
      List<TariffeCorriere> res = q.getResultList();
      return res.iterator();
    }
    finally
    {
      em.close();
    }
  }

  @Override
  public long size()
  {
    EntityManager em = PM.getEM();
    try
    {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Long> cq = cb.createQuery(Long.class);
      Root<TariffeCorriere> root = cq.from(TariffeCorriere.class);
      cq.select(cb.count(root));
      return em.createQuery(cq).getSingleResult();
    }
    finally
    {
      em.close();
    }
  }

  @Override
  public IModel<TariffeCorriere> model(TariffeCorriere object)
  {
    return new TariffeCorriereModel(object.getId());
  }

}
