package main

import (
	"github.com/bblfsh/sdk/protocol/driver"

	"github.com/bblfsh/bash-driver/driver/normalizer"
)

var version string
var build string

func main() {
	d := driver.Driver{
		Version:           version,
		Build:             build,
		UASTParserBuilder: normalizer.UASTParserBuilder,
		Annotate:          normalizer.AnnotationRules,
	}
	d.Exec()
}
