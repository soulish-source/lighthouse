package com.soulish.lighthouse.chapter.service;

import com.soulish.lighthouse.chapter.entity.Chapter;
import com.soulish.lighthouse.chapter.repository.ChapterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChapterCommandService {

    private final ChapterRepository chapterRepository;

    public ChapterCommandService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @Transactional
    public Chapter create(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Transactional
    public Chapter update(String id, Chapter updated) {
        Chapter existing = chapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chapter not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setVolumeTitle(updated.getVolumeTitle());
        existing.setStatus(updated.getStatus());
        existing.setPov(updated.getPov());
        existing.setTargetWordCount(updated.getTargetWordCount());
        existing.setCurrentWordCount(updated.getCurrentWordCount());
        existing.setNote(updated.getNote());
        existing.setCharacters(updated.getCharacters());
        existing.setForeshadows(updated.getForeshadows());
        return chapterRepository.save(existing);
    }

    @Transactional
    public void delete(String id) {
        chapterRepository.deleteById(id);
    }
}
