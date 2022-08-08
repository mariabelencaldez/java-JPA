package com.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.produtos.entidades.Produtos;
import com.produtos.repository.IProdutosRepository;

@Controller
@RequestMapping	("/")
public class ControllerProdutos {
	
	@Autowired
	private IProdutosRepository repo;
	
	@GetMapping
	public String index() {
		return "indexProdutos";
	}
	
	@GetMapping("/cadastroProdutos")
	public String formCadastro() {
		return "cadastroProdutos";
	}
	
	@GetMapping("/consultaProdutos")
	public String formConsulta(Model model) {
		Iterable<Produtos> produtos = repo.findAll();
		model.addAttribute("produtos", produtos);
		return "consultaProdutos";
	}

	@GetMapping("/consultaProdutos/{idproduto}")
	public String formEditar(@PathVariable("idproduto") int id, Model model) {
		Produtos produto = repo.findById(id).get();
		model.addAttribute("produto",produto);
		return "edicaoProdutos";
	}
	
	@PostMapping("/cadastroProdutos")
	public String salvar(Produtos produto) {
		
		repo.save(produto);
		return "redirect:/consultaProdutos";
	}
	
	@GetMapping("/deleteProdutos/{idproduto}")
	public String delete (@PathVariable("idproduto") int id, Model model) {
		repo.deleteById(id);
		return "redirect:/consultaProdutos";
	}

	
}
