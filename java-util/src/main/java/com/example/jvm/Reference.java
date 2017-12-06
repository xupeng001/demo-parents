package com.example.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

import scala.ref.SoftReference;

/**
 * @author xupen
 *
 */
public class Reference {

	public static void main(String[] args) {

		/**
		 * 强引用
		 */
		Reference ref = new Reference();

		/**
		 * 软引用
		 */
		SoftReference<Reference> softReference = new SoftReference<Reference>(ref);

		Reference reference = softReference.get().get();
		
		
		/**
		 * 弱引用
		 */
		WeakReference<Reference> weakReference = new WeakReference<Reference>(new Reference());
		Reference reference2 = weakReference.get();
		
		/**
		 * 虚引用
		 */
		
//		PhantomReference<Reference> phantomReference=new PhantomReference<Reference>(referent, q)
	}

}
