# Clojure Mindmap

This mindmap is defined in [`mindmap.puml`](mindmap.puml) using [PlantUML](https://plantuml.com/mindmap-diagram) syntax.

A rendered PNG is automatically generated as a GitHub Actions artifact on every push to `master`.

## Rendering locally

```bash
docker run --rm -v "$(pwd)":/data ghcr.io/plantuml/plantuml -tpng /data/mindmap.puml
```

This produces `mindmap.png` in the project root.