const Sequelize = require('sequelize');

const sequelize = new Sequelize('dictionary', 'root', '********', {
	host: 'localhost',
	dialect: 'mysql',
	define: {
		charset: 'utf8',
		collate: 'utf8_general_ci'
	}
});

const NoteInfo = sequelize.define(
	'NoteInfo',
	{
		Id: {
			type: Sequelize.INTEGER,
			autoIncrement: true,
			primaryKey: true
		},
		Emersion: {
			type: Sequelize.FLOAT,
			allowNull: false,
			defaultValue: '100.0'
		}
	},
	{
		classMethods: {},
		tablesName: 'NoteInfo',
		freezeTableName: true,
		underscored: true,
		timesettamps: false
	}
);

const DataInfo = sequelize.define(
	'DataInfo',
	{
		Id: {
			type: Sequelize.INTEGER,
			autoIncrement: true,
			primaryKey: true
		},
		result: {
			type: Sequelize.JSON,
			allowNull: true
		}
	},
	{
		classMethods: {},
		tablesName: 'DataInfo',
		freezeTableName: true,
		underscored: true,
		timesettamps: false
	}
);

module.exports = {
	sequelize,
	NoteInfo,
	DataInfo
};