// make chart view
const fs = require('fs');
const output = require('d3node-output');
const d3 = require('d3-node')().d3;
const pie = require('./pie');
const line = require('./line');

const csvString = fs.readFileSync('../data/pie.csv').toString();
let data = d3.csvParse(csvString);
output('./pie', pie({ data: data }));

const parseTime = d3.timeParse('%d-%b-%y');
const tsvString = fs.readFileSync('../data/line.tsv').toString();
data = d3.tsvParse(tsvString, d => {
	return {
		key: parseTime(d.date),
		value: +d.close
	};
});

output('./line', line({ data: data }), { width: 960, height: 550 });