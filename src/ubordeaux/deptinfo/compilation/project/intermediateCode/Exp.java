package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Exp extends IntermediateCode {

	public Exp() {
		super();
	}
	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}

}