package poly.controller.admin;

import java.util.List;

import org.hibernate.HibernateException;
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

@Transactional
@Controller
@RequestMapping("/homeAdmin/employe")
public class manage_employe {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView homePage() {
		
		ModelAndView mav = new ModelAndView("admin/manage_employe");
		return mav;
	}

	@Autowired
	SessionFactory factory;

	@RequestMapping("/manage_employe")
	/*
	 * public String index(ModelMap model) { Session session =
	 * factory.openSession(); String hql = "FROM Customer WHERE Status = 1"; Query
	 * query = session.createQuery(hql); List<Customer> list = query.list();
	 * model.addAttribute("Customer", list); session.close(); return
	 * "admin/manage_employe"; }
	 */

	public String customer(ModelMap model) {
		Session session = factory.openSession();
		String hql = "FROM Customer WHERE Status = 1";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		model.addAttribute("Customer", list);
		session.close();
		return "admin/manage_employe";
	}

	public Customer getCustomer_ByID(int customerID) {
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Customer kh = (Customer) session.get(Customer.class, customerID);
			return kh;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}

	@RequestMapping(value = "deletekh/{Customer}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("Customer") int customerID) {
		Customer kh = getCustomer_ByID(customerID);

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			kh.setStatus(0);
			session.update(kh);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return customer(model);
	}

	@RequestMapping(value = "/insert_customer", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("Customer", new Customer());
		return "admin/insert_customer";
	}

	@RequestMapping(value = "insert_customer", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("Customer") Customer customer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			customer.setStatus(1);
			session.save(customer);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại !");
		} finally {
			session.close();
		}
		Session session1 = factory.openSession();
		String hql1 = "FROM Customer WHERE Status = 1";
		Query query1 = session1.createQuery(hql1);
		List<Customer> list1 = query1.list();

		session.close();
		model.addAttribute("Customer", list1);
		return "admin/manage_employe";
	}

	@RequestMapping(value = "update_customer/{Customer}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("Customer") int customerID) {
		Session session = factory.openSession();
		String hql = "from Customer where customerID = :customerID ";
		Query query = session.createQuery(hql);
		query.setInteger("customerID", customerID);
		Customer kh = (Customer) query.uniqueResult();
		model.addAttribute("customer", kh);
		return "admin/update_customer";
	}

	@RequestMapping(value = "/update_customer", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("customer") Customer customer) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			System.out.println(customer.getCustomerName());
			session.update(customer);
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
		String hql2 = "FROM Customer WHERE Status = 1";
		Query query2 = session2.createQuery(hql2);
		List<Customer> list1 = query2.list();

		session.close();
		model.addAttribute("Customer", list1);
		return "admin/manage_employe";
	}

}
