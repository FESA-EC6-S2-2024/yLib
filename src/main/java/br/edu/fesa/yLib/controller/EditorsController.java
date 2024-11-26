package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.model.Editor;
import br.edu.fesa.yLib.service.EditorService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author Grupo_7
 */
@Controller
@RequestMapping("/editors")
@PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
public class EditorsController {

  @Autowired private EditorService editorService;

  @GetMapping
  public String listEditors(Model model) {
    model.addAttribute("editors", editorService.findAll());
    return "editors/list";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("editor", Editor.builder().build());
    return "editors/create";
  }

  @PostMapping("/create")
  public String createEditor(@Valid @ModelAttribute Editor editor, BindingResult result) {
    if (result.hasErrors()) {
      return "editors/create";
    }
    editorService.save(editor);
    return "redirect:/editors";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable UUID id, Model model) {
    model.addAttribute("editor", editorService.findById(id));
    return "editors/edit";
  }

  @PostMapping("/edit/{id}")
  public String updateEditor(
      @PathVariable UUID id, @Valid @ModelAttribute Editor editor, BindingResult result) {
    if (result.hasErrors()) {
      return "editors/edit";
    }
    editorService.update(id, editor);
    return "redirect:/editors";
  }

  @GetMapping("/delete/{id}")
  public String deleteEditor(@PathVariable UUID id) {
    editorService.delete(id);
    return "redirect:/editors";
  }
}
