# Clojure Mindmap

This mindmap is defined in [`mindmap.puml`](mindmap.puml) using [PlantUML](https://plantuml.com/mindmap-diagram) syntax.

![Clojure Mindmap](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/julian-schn/113478a-functional-programming/main/mindmap.puml)

## Rendering locally

```bash
docker run --rm -v "$(pwd)":/data ghcr.io/plantuml/plantuml -tpng /data/mindmap.puml
```