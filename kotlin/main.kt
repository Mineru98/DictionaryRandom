class NoteInfo(val id: Int, val Emersion: Int)

fun genertor(list: ArrayList<Int>, max: Int, e_data: ArrayList<Int>) {
	for (count in 1..max) {
		val rand: Int = (Math.floor(Math.random() * list.size)).toInt()
		val fix: Int = list[rand]
		e_data.add(fix)
		var i = 0
		println(list)
		while(i<list.size) {
			println(""+list[i]+", "+fix)
			// i가 1일때 Error가 생김
			if((list[i] == fix) && i!=1){
				while(list.remove(fix)) {}
				i--
			}else{
				i++
			}
		}
	}
}

fun main(args: Array<String>) {
	// db get noteList
	var initnoteList = ArrayList<NoteInfo>() // 원본 배열
	
	for (i in 1..10) {
		initnoteList.add(NoteInfo(i, 1))
	}
	
	var noteList = ArrayList<Int>()

	initnoteList.forEach {
		for(i in 1..(it.Emersion)) {
			noteList.add(it.id)
		}
	}
	
	var rnoteList = ArrayList<Int>()
	genertor(noteList, 4, rnoteList)
	println(rnoteList) 

}