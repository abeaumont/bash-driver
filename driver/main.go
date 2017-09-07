package main

import (
	"gopkg.in/bblfsh/sdk.v0/protocol/driver"

	"github.com/bblfsh/bash-driver/driver/normalizer"
)

var version string
var build string

func main() {
	d := driver.Driver{
		Version:       version,
		Build:         build,
		ParserBuilder: normalizer.ParserBuilder,
		Annotate:      normalizer.AnnotationRules,
	}
	d.Exec()
}
