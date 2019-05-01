package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TempValueList {
	private TempValue head;
	private TempValueList tail;

	public TempValueList(TempValue head, TempValueList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}

}
