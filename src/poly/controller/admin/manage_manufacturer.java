package poly.controller.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Customer;
import poly.entity.Manufacturer;

@Transactional
@Controller
@RequestMapping("/homeAdmin/manufacturer")
public class manage_manufacturer {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView mav = new ModelAndView("/admin/manufacturer");
		return mav;
	}

	@Autowired
	SessionFactory factory;

	@RequestMapping("/manage_manufacturer")

	public String manufacturer(ModelMap model) {
		Session session = factory.openSession();
		String hql = "FROM Manufacturer";
		Query query = session.createQuery(hql);
		List<Manufacturer> list = query.list();
		model.addAttribute("Manufacturer", list);
		session.close();
		return "admin/manage_manufacturer";
	}

	@RequestMapping(value = "/insert_manufacturer", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("Manufacturer", new Manufacturer());
		return "admin/insert_manufacturer";
	}

	@RequestMapping(value = "insert_manufacturer", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("Manufacturer") Manufacturer manufacturer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(manufacturer);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại !");
		} finally {
			session.close();
		}
		Session session1 = factory.openSession();
		String hql1 = "FROM Manufacturer";
		Query query1 = session1.createQuery(hql1);
		List<Manufacturer> list1 = query1.list();

		session.close();
		model.addAttribute("Manufacturer", list1);
		return "admin/manage_manufacturer";
	}

	@RequestMapping(value = "update_manufacturer/{Manufacturer}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("Manufacturer") int manufacturerID) {
		Session session = factory.openSession();
		String hql = "from Manufacturer where manufacturerID = :manufacturerID ";
		Query query = session.createQuery(hql);
		query.setInteger("manufacturerID", manufacturerID);
		Manufacturer ncc = (Manufacturer) query.uniqueResult();
		model.addAttribute("manufacturer", ncc);
		return "admin/update_manufacturer";
	}

	@RequestMapping(value = "/update_manufacturer", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("manufacturer") Manufacturer manufacturer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(manufacturer);
			t.commit();
			model.addAttribute("message", "Cập nhật thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Cập nhật thất bại !");
		} finally {
			session.close();
		}
//		return "admin/update_customer";
		Session session2 = factory.openSession();
		String hql2 = "FROM Manufacturer";
		Query query2 = session2.createQuery(hql2);
		List<Manufacturer> list1 = query2.list();

		session.close();
		model.addAttribute("Manufacturer", list1);
		return "admin/manage_manufacturer";
	}
}