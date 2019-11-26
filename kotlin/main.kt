import kotlin.system.exitProcess

class NoteInfo(val id: Int, val Emersion: Int)
// id is just Numbering of Object
// Emersion is a field that specifies the probability that a NoteInfo object will appear.

fun genertor(list: ArrayList<Int>, max: Int, e_data: ArrayList<Int>) {
	for (count in 1..max) {
		val rand: Int = (Math.floor(Math.random() * list.size)).toInt()
		val fix: Int = list[rand]
		var tmp =  ArrayList<Int>()
		
		e_data.add(fix)
		var i = 0
		while(i<list.size) {
			// println(""+list[i]+", "+fix) // if you want to debugging, remove remark
			if((list[i] == fix) && i!=0){
				tmp.add(fix)
				// while(list.remove(fix)) {} // Trade off : Memory vs Readability
				list.removeAll(tmp)
				tmp.clear()
				i--
			} else i++
		}
	}
}

fun main(args: Array<String>) {
	
	var initnoteList = ArrayList<NoteInfo>() // Original Array
	
	/*
		We need to insert code(Get initnoteList data from DB)
	*/
	
	for (i in 1..10) {
		// When creating a NoteInfo object, instead of 1, enter the probability value you want in the second parameter position.
		initnoteList.add(NoteInfo(i, 10))
	}
	
	// under code is production version code
	
	/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 
	
	if(1 > args.size) exitProcess(1)
	
	for (i in 1..args[0].toInt()) {
		// When creating a NoteInfo object, instead of 1, enter the probability value you want in the second parameter position.
		initnoteList.add(NoteInfo(i, 1))
	}
	
	*/
	
	var noteList = ArrayList<Int>()

	initnoteList.forEach {
		for(i in 1..(it.Emersion)) {
			noteList.add(it.id)
		}
	}
	
	// if(2 > args.size) exitProcess(1)
	var rnoteList = ArrayList<Int>()
	// genertor(noteList, args[1].toInt(), rnoteList)
	genertor(noteList, 4, rnoteList)
	println(rnoteList) 
}