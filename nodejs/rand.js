const NodeSchedule = require('node-schedule');
const DictionaryDB = require('./model');
var data = []; // 원본 배열
let e_data = []; // 최종 Expose 배열

function genertor(list, max) {
	for (var count = 0; count < max; count++) {
		const rand = Math.floor(Math.random() * list.length);
		const fix = list[rand];
		e_data.push(fix);
		for (var i = 0; i < list.length; i++) {
			if (list[i] == fix) {
				list.splice(i, 1);
				i--;
			}
		}
	}
}

DictionaryDB.sequelize
	.sync({
		force: true
	})
	.then(async () => {
		for (var i = 0; i < 10; i++) {
			if (i == 4 || i == 5)
				await DictionaryDB.sequelize.query(
					'INSERT INTO NoteInfo (emersion,created_at,updated_at) VALUES(50.0,now(),now())'
				);
			else
				await DictionaryDB.sequelize.query(
					'INSERT INTO NoteInfo (emersion,created_at,updated_at) VALUES(100.0,now(),now())'
				);
		}
	})
	.catch(err => {
		console.error(err);
	});

/*
DictionaryDB.sequelize.sync({
	force: false
}).then(async () => {
}).catch(err => {
	console.error(err);
});
*/

setInterval(() => {
	DictionaryDB.NoteInfo
		.findAll()
		.then(note => {
			// 빈도수에 따른 data 배열 push
			for (var i = 0; i < note.length; i++) {
				for (var j = 0; j < note[i].Emersion; j++) {
					data.push(note[i].Id);
				}
			}
		})
		.then(() => {
			genertor(data, 4);
			let json = `{`;
			for (var i = 0; i < e_data.length; i++) {
				if (i == e_data.length - 1) {
					json += `'id':${e_data[i]}`;
				} else {
					json += `'id':${e_data[i]}, `;
				}
			}
			json += `}`;
			DictionaryDB.DataInfo.create({
				result: json
			});
			data = [];
			e_data = [];
		});
}, 1000);