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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Manufacturer;
import poly.entity.Supplier;

@Transactional
@Controller
@RequestMapping("/homeAdmin/supplier")
public class manage_supplier {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView mav = new ModelAndView("/admin/supplier");
		return mav;
	}

	@Autowired
	SessionFactory factory;

	@RequestMapping("/manage_supplier")

	public String manufacturer(ModelMap model) {
		Session session = factory.openSession();
		String hql = "FROM Supplier";
		Query query = session.createQuery(hql);
		List<Supplier> list = query.list();
		model.addAttribute("Supplier", list);
		session.close();
		return "admin/manage_supplier";
	}

	@RequestMapping(value = "/insert_supplier", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("Supplier", new Supplier());
		return "admin/insert_supplier";
	}

	@RequestMapping(value = "insert_supplier", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("Supplier") Supplier supplier) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(supplier);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại !");
		} finally {
			session.close();
		}
		Session session1 = factory.openSession();
		String hql1 = "FROM Supplier";
		Query query1 = session1.createQuery(hql1);
		List<Supplier> list1 = query1.list();

		session.close();
		model.addAttribute("Supplier", list1);
		return "admin/manage_supplier";
	}

}
