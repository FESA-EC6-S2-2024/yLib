package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.model.Editor;
import br.edu.fesa.yLib.repository.EditorRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Grupo_7
 */
@Service
public class EditorService {

  @Autowired private EditorRepository editorRepository;

  public List<Editor> findAll() {
    return editorRepository.findAll();
  }

  public Editor findById(UUID id) {
    return editorRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Editor not found"));
  }

  @Transactional
  public Editor save(Editor editor) {
    return editorRepository.save(editor);
  }

  @Transactional
  public Editor update(UUID id, Editor editorDetails) {
    Editor editor = findById(id);
    editor.setName(editorDetails.getName());
    return editorRepository.save(editor);
  }

  @Transactional
  public void delete(UUID id) {
    Editor editor = findById(id);
    editorRepository.delete(editor);
  }
}
